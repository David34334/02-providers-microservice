# Providers Microservice

#### Providers Microservice for ProductCustomerApp.

This repository allows you the management of all providers necessary for ProductCustomerApp.

#### Repository contains:

* #### Providers Entities.
* #### Validations.

<hr/>

#### Port `8100`

<hr />

#### Endpoints

`http://localhost:8100/api/v1/providers` Create a new Provider
* #### Requirements:
    * Send `Provider` body with all information of the provider.
```
{
    "provider_name": "Test",
    "provider_email": "testg@gmail.com",
    "provider_address": "Address Test",
    "provider_city": "Any UUID valid in database"
}
```

### Required Libraries
This project need some local libraries to run:

* #### Product Customer Library
    * `product-customer-lb`: This library contains custom exceptions and transversal dtos used in many microservices. [Product Customer App - Library](https://github.com/David34334/product-customer-library)


### Swagger Documentation

--**[Pending]**--
