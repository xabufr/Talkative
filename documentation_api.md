Créer utilisateur (intégrer au site ?)
Poster, lire, lister

Lister les commentaires
URI = api/getCommentaires.json
Parameters = uid, sid, pid
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
          STATUS: unknow_site | unknow_user
