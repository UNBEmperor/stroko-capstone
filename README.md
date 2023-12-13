# STROKO API

# Documentation

## SignUp

- Method: POST
- Endpoint: /api/auth/signup
- Request Body:

  - `"username"`: `'string'`, must be unique
  - `"email"`: `'string'`, must be unique
  - `"password"`: `'string'`, must be at least 8 characters

- Response:

```json
{
  "status": 201,
  "password": "User registered successfully"
}
```

## SignIn

- Method: POST
- Endpoint: /api/auth/signin
- Request Body:

  - `"username"`: `'string'`
  - `"password"`: `'string'`

- Response:

```json
{
  "status": 200
  "password": "User logged successfully"
"accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
```

## Stroke Assessment

- Method: POST
- Endpoint: /api/stroke-assessment
- Header: x-access-token
- Request Body:

  - `"idUsers"`: `'num'` (Auto fill with userId)
  - `"nama"`: `'string'`
  - `"usia"`: `'num'`
  - `"gender"`: `'bool'`
  - `"levelBMI"`: `'bool'`
  - `"hipertensi"`: `'bool'`
  - `"diabetes"`: `'bool'`
  - `"penyakitJantung"`: `'bool'`
  - `"riwayatStrokePribadi"`: `'bool'`
  - `"riwayatStrokeKeluarga"`: `'bool'`
  - `"merokok"`: `'string'` (enum)
  - `"konsumsiAlkohol"`: `'string'` (enum)
  - `"aktivitasFisik"`: `'string'` (enum)
  - `"prediksiStroke"`: `'bool'` (Auto fill with false)

- Response:

```json
{
  "status": 200
  "password": "StrokeAssessment added successfully"
  "data": {
        "prediksiStroke": false,
        "id": 1,
        "idUsers": 2,
        "nama": "Vlad",
        "usia": 61,
        "gender": false,
        "levelBMI": 23,
        "hipertensi": false,
        "diabetes": false,
        "penyakitJantung": false,
        "riwayatStrokePribadi": false,
        "riwayatStrokeKeluarga": false,
        "merokok": "0",
        "konsumsiAlkohol": "1",
        "aktivitasFisik": "2",
        "updatedAt": "2023-12-13T10:44:17.896Z",
        "createdAt": "2023-12-13T10:44:17.896Z"
  }
}
```

## Stroke Assessment History

- Method: GET
- Endpoint: /api/stroke-assessment-history
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": [
    {
      "id": 1,
      "idUsers": 2,
      "nama": "Vlad",
      "usia": 61,
      "gender": false,
      "levelBMI": 23,
      "hipertensi": false,
      "diabetes": false,
      "penyakitJantung": false,
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": false,
      "merokok": "0",
      "konsumsiAlkohol": "1",
      "aktivitasFisik": "2",
      "prediksiStroke": false,
      "createdAt": "2023-12-13T10:44:17.000Z",
      "updatedAt": "2023-12-13T10:44:17.000Z"
    },
    {
      "id": 2,
      "idUsers": 2,
      "nama": "Konstantin",
      "usia": 41,
      "gender": false,
      "levelBMI": 21,
      "hipertensi": false,
      "diabetes": false,
      "penyakitJantung": true,
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": true,
      "merokok": "1",
      "konsumsiAlkohol": "3",
      "aktivitasFisik": "2",
      "prediksiStroke": false,
      "createdAt": "2023-12-13T10:46:19.000Z",
      "updatedAt": "2023-12-13T10:46:19.000Z"
    }
  ]
}
```
