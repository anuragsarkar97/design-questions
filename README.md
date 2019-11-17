# Gojek - Parking Lot Problem

## Introduction 

We have n cars and we have different operations to perform

#### Operation Type

- create a parking lot
- add cars (nearest to exit)
- remove cars from a given slot
- find cars with registration numbers 
- find all cars with same color


## Methodology

## Project structure 
```
.
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
│   │               ├── logger
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

19 directories, 22 files

```
