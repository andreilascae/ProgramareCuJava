# HealthSched – Cerințe de Business și Funcționalități MVP

## Cerințe de Business (BR1–BR10)

- **BR1**: Pacientul își poate crea și gestiona contul personal.  
- **BR2**: Administratorul poate defini clinici și specializări.  
- **BR3**: Medicul aparține unei clinici și are o specializare.  
- **BR4**: Medicul are asociate servicii medicale (consultație, control, analiză).  
- **BR5**: Pacientul poate vizualiza lista medicilor și detaliile lor.  
- **BR6**: Pacientul poate căuta medici după clinică sau specializare.  
- **BR7**: Pacientul poate crea, edita sau anula o programare.  
- **BR8**: Sistemul validează programările (fără suprapuneri, doar în viitor).  
- **BR9**: Programarea are un istoric de stare (CREATED, CONFIRMED, CANCELLED).  
- **BR10**: Pentru fiecare programare se poate înregistra o plată (PENDING, PAID, REFUNDED).

## Funcționalități principale (MVP)

- **F1**: Gestionare Pacienți (CRUD + validări).  
- **F2**: Gestionare Doctori (CRUD, paginare și sortare).  
- **F3**: Căutare și listare medici după clinică / specializare.  
- **F4**: Programări: creare / listare / anulare cu validări business.  
- **F5**: Plăți: creare plată și verificări (programare validă, fără duplicat).
