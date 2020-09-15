FORMAT: 1A
HOST: https://subscriptions13.apiblueprint.org/

# Subscriptions

This a *__Subscriptions__* module of Trendyol Bootcamp API.

---
# Notes

- Each users should have a free subscription plan by default.
- Each subscription record keeps one subscription period details.
- Simply we decided to use a static 'plan_id' property which represents the subscription type.

    | plan_id  | Representation  |
    |---|---|
    | 0 | Free Plan |
    | 1  | Premium Plan  |
    | 2  | Family Plan  |

- **Q-1:** Should we need to create an endpoint for deleting subscription?
- **Q-2:** Should we need to retrieve the subscripton by user id?

---
# Subscription

    Represents one period of subscription.
---

- id `(Number)` : Unique identifier.
- user_id `(Number)` : User's unique identifier.
- plan_id `(Number)` : Plan's id identifier.
- price `(Float)` : Billed price of the subscription.
- is_paid `(Boolean)` : It represents whether the payment has been made or not.
- start_date `(Date)` : The start date of subscription.
- end_date `(Date)` : The end date of subscription.

---

## Subscriptions [/subscriptions?{id}]

### List All Subscriptions [GET]

+ Response 200 (application/json)

        [
            {
                "id": 1,
                "user_id": 1,
                "plan_id": 1,
                "price": 17.99,
                "is_paid": true,
                "start_date": "2020-08-05T00:00:00.000Z",
                "end_date": "2020-09-05T00:00:00.000Z"
            },
            {
                "id": 1,
                "user_id": 1,
                "plan_id": 2,
                "price": 24.99,
                "is_paid": true,
                "start_date": "2020-09-05T00:00:00.000Z",
                "end_date": "2020-10-05T00:00:00.000Z"
            },
            {
                "id": 2,
                "user_id": 2,
                "plan_id": 2,
                "price": 24.99,
                "is_paid": true,
                "start_date": "2020-08-05T00:00:00.000Z",
                "end_date": "2020-09-05T00:00:00.000Z"
            }
        ]
        
+ Response 500 (application/json)

        {
            "error": "message.internal_server_error"
        }
    
### Create a New Subscription [POST]

+ Request (application/json)

        {
            "user_id": 1,
            "plan_id": 1,
        }

+ Response 201 (application/json)

    + Headers

            Location: /subscriptions/1

    + Body

            {
                "id": 1,
                "user_id": 1,
                "plan_id": 1,
                "price": 17.99, 
                "is_paid": true,
                "start_date": "2020-08-05T00:00:00.000Z",
                "end_date": "2020-09-05T00:00:00.000Z"
            }
            
+ Response 500 (application/json)

        {
            "error": "message.internal_server_error"
        }

### Change Subscription Plan [PATCH]

+ Request (application/json)

        {
            "id": 1,
            "new_plan_id": 2,
        }

+ Response 204 (application/json)

            
+ Response 500 (application/json)

        {
            "error": "message.internal_server_error"
        }

## Subscriptions/id [/subscriptions/{id}]

+ Parameters
    + id (number) - ID of the Subscription in the form of an integer    

### Get Subscription by ID [GET]

+ Response 200 (application/json)

        {
            "id": 1,
            "user_id": 1,
            "plan_id": 1,
            "price": 17.99,
            "is_paid": true,
            "start_date": "2020-08-05T00:00:00.000Z",
            "end_date": "2020-09-05T00:00:00.000Z"
        }
        
+ Response 404 (application/json)

        {
        
            "error": "message.subscription.not_found"
        }

### Delete Subscription [DELETE]

+ Response 204

+ Response 500 (application/json)

        {
            "error": "message.internal_server_error"
        }


## Subscriptions/id/payment [/subscriptions/{id}/payment]

+ Parameters
    + id (number) - ID of the Subscription in the form of an integer

### Pay Subscription Price [PATCH]
    
+ Request (application/json)

        {
            "id": 1,
            "card_owner_name": "Steve Jobs",
            "card_number": "5500 0000 0000 0004",
            "valid_thru_month": 11,
            "valid_thru_year": 28,
            "cvc": 256
        }

+ Response 204

+ Response 500 (application/json)

        {
            "error": "message.internal_server_error"
        }