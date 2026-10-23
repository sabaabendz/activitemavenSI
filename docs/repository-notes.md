
# Atelier 3 - Spring Data JPA

## 1. Choix des repositories

| Interface | Etend | Justification |
|---|---|---|
| IAgenceRepository | JpaRepository<Agence, Long> | CRUD complet, listes, tri et pagination |
| IClientRepository | JpaRepository<Client, Long> | CRUD complet, listes, tri et pagination |
| IContratRepository | JpaRepository<Contrat, Long> | CRUD complet et saveAndFlush disponible |
| IEmployeRepository | JpaRepository<Employe, Long> | CRUD complet, listes, tri et pagination |
| IEquipementRepository | JpaRepository<Equipement, Long> | CRUD complet, listes, tri et pagination |
| IMaintenanceRepository | JpaRepository<Maintenance, Long> | CRUD complet, listes, tri et pagination |
| IPaiementRepository | JpaRepository<Paiement, Long> | Lecture et gestion des paiements |
| IReservationRepository | JpaRepository<Reservation, Long> | CRUD complet, listes, tri et pagination |
| IVehiculeRepository | JpaRepository<Vehicule, Long> | CRUD complet, listes, tri et pagination |

## 2. Analyse SonarQube for IDE

Outil : SonarQube for IDE

Date : 23/10/2026

Résultat : aucune anomalie affichée dans les rapports consultés.

Aucune correction SonarQube n'a encore été réalisée.

## 3. Vérification Spring Data JPA

Les neuf interfaces Repository ont été détectées :

Found 9 JPA repository interfaces.

Les repositories permettent d'utiliser les méthodes CRUD
sans écrire manuellement leur implémentation.
