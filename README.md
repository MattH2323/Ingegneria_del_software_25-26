# Ingegneria_del_software_25-26
Repository created in order to track the activities related to the software engineering course 25/26

### Struttura della Repository
- `<hands_on1/>` :
    - `report.pdf` : report che dettaglia lo Scrum process con l'evoluzione del product backlog.
    - `code/` : cartella contenente il codice sviluppato durante gli sprint (in questo caso è stato effettuato un unico sprint).
- `<hands_on2/>` :
    - `srs-ieee_auth-library.doc` : documento SRS (Software Requirements Specification)
    - `usecase_diagram.drawio` : file XML del use case diagram utilizzato nell'SRS
- `<hands_on3/>` :
    - `*.drawio` : file XML relativo all'UML
    - `*.jpg` : file JPG (immagine) relativo all'UML
- `<hands_on4/>` :
    - `after/` : documentazione delle metriche e statistiche finali post-intervento
        - `out/` : report HTML relativi alla test coverage finale
        - `metrics.csv` : coding metrics misurate al termine tramite Scitools Understand
        - `summary` : sintesi in formato PDF delle statistiche conclusive
    - `before/` : documentazione dello stato iniziale del progetto
        - `out/` : report HTML relativi alla test coverage di partenza
        - `MISRA12_violations` e `summary` : report PDF delle violazioni dello standard MISRA 2012 rilevate all'inizio
        - `metrics.csv` : coding metrics misurate in fase iniziale tramite Scitools Understand
    - `violation_count_graphic.png` : rappresentazione grafica dell'evoluzione del numero di violazioni
- `<hands_on5/>` :
    - `AuthController.java` : REST API Java con funzionalità di login aggiunta
