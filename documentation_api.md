Créer utilisateur (intégrer au site ?)
Poster, lire, lister

Lister les commentaires
URI = api/users/{user}/sites/{site}/articles/{article}/comments
Method = GET
Return
   Success no content:
      HTTP CODE: 204
      CONTENT:
          -
   Success:
       HTTP CODE: 200
       CONTENT:
           A définir
      
   Error (uid/sid non valides, site non inscrit)
      HTTP CODE: 401
      JSON CONTENT: 
          STATUS: unknow_sit | unknow_user


Inscription d'un éditeur au service Talkative
URI = api/users/
Method = POST
Parameters = pseudo, email, password
Return
   Success:
      HTTP CODE: 201 
      CONTENT:
         {
            UID:
         }
      HTTP CODE: 409
      CONTENT:
      -
      Error (Utilisateur déjà existant)
      
      HTTP CODE: 412
      CONTENT:
      {
         InvalidFields : []
         
      }
      Error (mot de passe / mail / pseudo non valide)
      
