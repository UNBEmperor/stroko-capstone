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
  - `"merokok"`: `'bool'`
  - `"konsumsiAlkohol"`: `'bool'`
  - `"aktivitasFisik"`: `'bool'`
  - `"prediksiStroke"`: `'bool'` (false default)

- Response:

```json
{
  "status": 200
  "password": "StrokeAssessment added successfully"
  "data": {
        "id": 18,
        "idUsers": 2,
        "nama": "Clausewitz",
        "usia": 32,
        "gender": false,
        "levelBMI": 27,
        "hipertensi": false,
        "diabetes": false,
        "penyakitJantung": true,
        "merokok": false,
        "konsumsiAlkohol": "Jarang",
        "aktivitasFisik": "Tinggi",
        "riwayatStrokePribadi": false,
        "riwayatStrokeKeluarga": true,
        "prediksiStroke": false, (Alter table after result came out?)
        "updatedAt": "2023-12-12T08:22:09.830Z",
        "createdAt": "2023-12-12T08:22:09.830Z"
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
      "id": 2,
      "idUsers": 1,
      "nama": "Alice Johnson",
      "usia": 50,
      "gender": false,
      "hipertensi": true,
      "diabetes": true,
      "penyakitJantung": true,
      "merokok": true,
      "levelBMI": 30,
      "konsumsiAlkohol": "Jarang Sekali",
      "aktivitasFisik": "Sedang",
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": false,
      "prediksiStroke": true,
      "createdAt": "2023-12-10T05:43:45.000Z",
      "updatedAt": "2023-12-10T05:43:45.000Z"
    },
    {
      "id": 7,
      "idUsers": 1,
      "nama": "Jurgen",
      "usia": 41,
      "gender": false,
      "hipertensi": false,
      "diabetes": false,
      "penyakitJantung": true,
      "merokok": false,
      "levelBMI": 27,
      "konsumsiAlkohol": "Tidak Pernah",
      "aktivitasFisik": "Tinggi",
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": true,
      "prediksiStroke": false,
      "createdAt": "2023-12-11T06:47:05.000Z",
      "updatedAt": "2023-12-11T06:47:05.000Z"
    },
    {
      "id": 8,
      "idUsers": 1,
      "nama": "Hans Peiper",
      "usia": 31,
      "gender": false,
      "hipertensi": false,
      "diabetes": false,
      "penyakitJantung": true,
      "merokok": false,
      "levelBMI": 27,
      "konsumsiAlkohol": "Jarang",
      "aktivitasFisik": "Tinggi",
      "riwayatStrokePribadi": false,
      "riwayatStrokeKeluarga": true,
      "prediksiStroke": false,
      "createdAt": "2023-12-11T06:49:48.000Z",
      "updatedAt": "2023-12-11T06:49:48.000Z"
    }
  ]
}
```
