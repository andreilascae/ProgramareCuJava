# HealthSched – Platformă pentru programări medicale

## Descriere
Aplicație web realizată în Spring Boot 3, care permite gestionarea clinicilor, medicilor, pacienților, programărilor și plăților.  
Include interfață web (Thymeleaf) și API REST documentat cu Swagger/OpenAPI.

---

## Cum rulezi aplicația

### Cerințe
- Java 17+
- Maven 3+
- MySQL (sau poți rula pe profilul "test" cu H2)

### Pași
1) Clonează repo:
   git clone https://github.com/<user>/HealthSched.git
   cd HealthSched

2) Rulează aplicația:
   mvn spring-boot:run

3) Accesează în browser:
   - UI: http://localhost:8080/
   - Swagger: http://localhost:8080/swagger-ui/index.html

---

## Profile disponibile
- dev: folosește MySQL (configurat în application-dev.properties)
  spring.datasource.url=jdbc:mysql://localhost:3306/healthsched
  spring.datasource.username=root
  spring.datasource.password=12345678

- test: folosește H2 in-memory (pentru teste automate)

---

## User demo
Aplicația are configurat un user in-memory:
- Username: admin
- Password: admin

---

## Funcționalități principale
- CRUD pentru pacienți și doctori.
- Căutare și listare doctori cu paginare și sortare.
- Programări: creare, listare, anulare, validări (fără suprapuneri, doar în viitor).
- Plăți: creare plată pentru programare validă.
- Documentație API disponibilă prin Swagger.

---

## Documentație cerințe
În folderul /docs există fișierul requirements.md unde sunt descrise:
- 10 cerințe de business (BR1–BR10)
- 5 funcționalități principale (MVP)

Acest document servește ca punct de referință pentru verificarea acoperirii cerințelor proiectului.

---

## Testare
Rulează testele:
mvn test

Testele acoperă:
- Serviciul de programări (validări, erori, happy path).
- Controllerul REST pentru programări.

---

## Colecție Postman
În folderul /docs se găsește fișierul HealthSched.postman_collection.json cu request-uri de test pentru:
- CRUD Pacienți / Doctori
- Creare Programare
- Anulare Programare
- Creare Plată

Se poate importa direct în Postman pentru a testa rapid funcționalitățile aplicației.

---

## Screenshots
În folderul /screenshots se află capturi de ecran relevante:
- Swagger UI cu toate endpointurile vizibile.
- Exemplu de răspuns JSON la crearea unei programări.
- Exemple pentru cazuri de succes (201/200) și pentru erori (400/409).
