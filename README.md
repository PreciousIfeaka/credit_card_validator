# Credit Card Validator API

This API is built on Java/SpringBoot and uses Luhn's Algorithm to determine the validity of a credit card number.

### Example Input

```json
{
  "cardNumber": "5399831619690403"
}
```

### Example Response

```json
{
  "cardType": "mastercard",
  "cardNumber": "5399831619690403",
  "cardLength": 16,
  "validityStatus": "valid"
}
```

