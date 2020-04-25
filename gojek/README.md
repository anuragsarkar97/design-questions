# Gojek - Parking Lot Problem

## Introduction 

We have n cars and we have different operations to perform

#### Operation Type

- create a parking lot
- add cars (nearest to exit)
- remove cars from a given slot
- find cars with registration numbers 
- find all cars with same color


## Assumptions

- Once a parking lot has been created we cannot overwrite and create another parking lot. To begin you have to restart the project.
- I have also assumed the frequency if each task to computed and based on that decided the data structure to use.
    * park and remove car (Avg request 1000)
    * query (Avg request 50)
 

## Project structure 
```
.
├── README.md
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── io
    │   │       └── gojek
    │   │           └── parkinglot
    │   │               ├── ParkingLotApplication.java
    │   │               ├── costants
    │   │               │   └── ParkingLotConstants.java
    │   │               ├── exceptions
    │   │               ├── executor
    │   │               │   ├── ExecutorInterface.java
    │   │               │   ├── FileExecutor.java
    │   │               │   └── InstructionExecutor.java
    │   │               ├── models
    │   │               │   ├── Car.java
    │   │               │   ├── ParkingLot.java
    │   │               │   ├── Slot.java
    │   │               │   ├── Vehicle.java
    │   │               │   └── enums
    │   │               │       ├── Color.java
    │   │               │       ├── InstructionType.java
    │   │               │       ├── SlotStatus.java
    │   │               │       └── SlotType.java
    │   │               ├── service
    │   │               │   ├── ParkingLotService.java
    │   │               │   └── impl
    │   │               │       ├── ParkingAllocatorService.java
    │   │               │       ├── ParkingDeallocatorService.java
    │   │               │       ├── ParkingInformationService.java
    │   │               │       ├── ParkingInitializeService.java
    │   │               │       └── ParkingStatusService.java
    │   │               ├── util
    │   │               └── validator
    │   │                   ├── ValidationInterface.java
    │   │                   └── impl
    │   │                       ├── FileValidator.java
    │   │                       └── InstructionValidator.java
    │   └── resources
    │       └── test.txt
    └── test
        └── java
            └── mainTest.java

```

## Project Requirements

```
- java1.8
- maven > 2.0.0
- docker (If required)
```

## How to run.

#### Running functional test
```bash
cd parking-lot-1.4.2
cd parking_lot/bin
sh setup
./parking_lot
./run_functional_test
```

#### Running through commandline
```bash
cd parking-lot-1.4.2
cd parking_lot/gojek
mvn clean install 
java -jar target/gojek-1.0-SNAPSHOT.jar
```

#### Running with docker
```bash 
cd parking-lot-1.4.2
cd parking_lot/gojek
docker build .

```

