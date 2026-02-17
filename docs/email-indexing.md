🔍 Analyse des plans d’exécution — Avant / Après index sur users.email
Avant l’ajout de l’index, la requête ```SELECT * FROM users WHERE email = 'jo.cahkir@shift.flow.com' ``` était exécutée via un Seq Scan (balayage séquentiel de la table). 
Le plan indiquait un temps d’exécution réel de 0,047 ms, avec un coût estimé faible mais une opération coûteuse en I/O aléatoire, car PostgreSQL devait parcourir toute la table pour trouver la ligne correspondante.
<img width="1197" height="614" alt="Screenshot 2026-02-16 233944" src="https://github.com/user-attachments/assets/5ad6b528-f3a6-4647-b852-c5a70d216991" />

Après avoir ajouté l’index B-tree via l’annotation @Index(name = "idx_users_email", columnList = "email") sur l’entité User, et redémarré l’application (pour que Hibernate crée l’index physique), la même requête utilise désormais un Index Scan sur idx_users_email. Le temps d’exécution chute à 0,031 ms.
<img width="1412" height="630" alt="Screenshot 2026-02-16 234152" src="https://github.com/user-attachments/assets/e4cbc44c-bc9b-4a10-9ddb-fb4da611a728" />
Ce gain est rendu possible grâce à :
- L’accès direct via l’arbre B-tree (sans parcourir la table),
- La localisation immédiate de la ligne par la clé email,
- L’absence de filtrage supplémentaire (le filtre est intégré à l’index).
- Cela confirme que l’index a été correctement créé et utilisé par le moteur PostgreSQL — une validation cruciale pour la stratégie - d’optimisation des requêtes critiques (comme findByEmail() dans l’authentification).
