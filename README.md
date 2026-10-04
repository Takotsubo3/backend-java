

## Features

* Driver CRUD operations
* Vehicle CRUD operations
* Car and Truck management
* Driver and vehicle relationships
* JPA inheritance between Vehicle, Car and Truck
* Database persistence
* REST API



## Entity Relationships

### Vehicle Inheritance

```text
                Vehicle
                /     \
              Car     Truck
```


## API Endpoints

### Drivers

```text
GET    /driver/all : http://localhost:8080/driver/all
GET    /driver/{id} : http://localhost:8080/1/vehicle/3
POST   /driver : http://localhost:8080/driver?name=Leo&age=35
PUT    /driver/{id} : http://localhost:8080/driver/2?name=test2&age=35
DELETE /driver/{id} : http://localhost:8080/driver/2
PUT /driver/{id}/vehicle/{id} : http://localhost:8080/driver/1/vehicle/3
```

### Cars

```text
GET    /car/all : http://localhost:8080/car/all
GET    /car/{id} : http://localhost:8080/car/3
POST   /car : http://localhost:8080/car?brand=bmw&model=batmobile&year=2000&price=150
PUT    /car/{id} : http://localhost:8080/truck/3?brand=batmo&model=vvv&year=2001&price=250&weight=2500
DELETE /car/{id} : http://localhost:8080/car/1
```

### Trucks

```text
GET    /truck/all : http://localhost:8080/truck/all
GET    /truck/{id} : http://localhost:8080/truck/4
POST   /truck : http://localhost:8080/truck?brand=test&model=model&year=2012&price=2500&weight=2000
PUT    /truck/{id} : http://localhost:8080/truck/3?brand=batmo&model=vvv&year=2001&price=250&weight=2500
DELETE /truck/{id} : http://localhost:8080/truck/4
```
## Author

### Mary-Kate L'Entété
