# Bilabonnement backend
Det her er backend delen af vores projekt
* Backend er lavet i Springboot java med hibernate og JPA relations

# API-Dokumentation
Vores API prøver at følge REST-principper i struktur med at være universel og læselig på tværs af alle calls.


**CarController API**

@GetMapping("/api/cars")  
Dette API call finder listen af alle biler

@GetMapping("/api/cars/getCar/{carId}")  
Dette API call finder en specifik bil ud fra bilens ID i JSON format

@PostMapping("/api/cars/addCar")  
Dette API call vil gemme en ny bils information som JSON 

@PutMapping("/api/cars/setCarAvailable/{carId}")  
Dette API call gør så brugeren kan ændre på en bils status baseret på veligeholdelse

@PutMapping("/api/cars/updateCarStatus/{carId}")  
Dette API call gør så brugeren kan opdatere en bils status til reserved

---

**CustomerController API**

@GetMapping("/api/customers")  
Dette API call henter alle kunderne fra databasen

@PostMapping("/api/addCustomer")  
Dette API call opretter en kunde i databasen ved at gemme kundens information, og retunere kunden for at bekræfte at kunden er blevet oprettet

@GetMapping("/api/customers/getCustomer/{customerId}")  
Dette API call giver brugeren en kundes information ud fra kundens ID

@GetMapping("/api/customers/checkCredit/{customerId}")  
Dette API call lader brugeren se en kundes credit

---

**DamageReportController API**

@GetMapping("/api/damageReports")  
Dette API call finder alle skaderapporter som en liste

 @PostMapping("/api/damageReport/createDamageReport")  
Dette API call lader brugeren lave en skaderapport til en bils ID, og opdatere bilens status

@PutMapping("/api/damageReports/updateRepairComplete/{reportId}")  
Dette API call lader brugeren opdatere skaderapport statusen til repairComplete

---

**LeandingAgreementController API**

@GetMapping("/api/lendingAgreements")  
Dette API call finder alle udlånsaftaler i systemet

@GetMapping("/api/lendingAgreements/getLendingAgreement/{lendingAgreementId}")  
Dette API call finder en specifik udlånsaftale ud fra den ID 

@PostMapping("/api/lendingAgreements/createLendingAgreement")  
Dette API call lader brugeren lave en udlånsaftale hvis requestbody'en er korrekt. Den bruger kundens og bilens ID for at lave en constructor
