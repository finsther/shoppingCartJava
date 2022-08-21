### GET product list

**http://localhost:8080/api/getAllProducts**

 **Response** 
 
 ```json
[
    {
        "id": 789704358538543106,
        "name": "Torre Empresarial I",
        "description": "Oficinas",
        "quantity": 40,
        "price": 3890.0
    }
]
```

### POST make new order
**http://localhost:8080/api/makeNewOrder**

```json
 {
    "products": [
        {
            "productId": 789704358538543106,
            "quantity": 10,
            "amount": 3890
        }
    ],
    "customerEmail": "Lorem@outlook.com",
    "customerName": "Lorem Tempor",
    "customerAddress": "Unknown #322",
    "customerPhone": "3334445566"
}
```

 **Response** 
 
 return empty body when no product availability
 
```json
 {
    "amount": 38900.0,
    "number": 2309,
    "creationDate": "2022-08-21T08:38:52.034+00:00",
    "orderId": 789711200253673474
}
```
### POST add new brick
**http://localhost:8080/api/products**

```json
{
        "description": "Oficinas",
        "name": "Torre Empresarial I",
        "price": "3890",
        "quantity": "50"
}
```

### GET order by id
**http://localhost:8080/api/getOrder/789711200253673474**

 **Response** 

```json
{
    "id": 789704436378861570,
    "number": 4779,
    "creationDate": "2022-08-21T08:04:27.908+00:00",
    "customer": {
        "id": 789704434238324738,
        "name": "Eiusd Tempor",
        "email": "Eiusd@outlook.com",
        "address": "Unknown #32",
        "phone": "3334445566"
    },
    "cartItems": [
        {
            "id": 789704436924317698,
            "productId": 789704358538543106,
            "quantity": 1,
            "amount": 3890.0
        }
    ]
}
```
