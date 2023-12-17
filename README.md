# STROKO API

# Documentation

## SignUp

- Method: POST
- Endpoint: /api/auth/signup
- Request Body:

  - `"email"`: `'string'`, must be unique and using email format
  - `"username"`: `'string'`
  - `"password"`: `'string'`, must be at least 8 characters

- Response:

```json
{
  "status": 201,
  "message": "User registered successfully"
}
```

## SignIn

- Method: POST
- Endpoint: /api/auth/signin
- Request Body:

  - `"email"`: `'string'`
  - `"password"`: `'string'`

- Response:

```json
{
  "status": 200,
  "id": "1",
  "message": "User logged successfully",
  "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9"
}
```

## Stroke Assessment

- Method: POST
- Endpoint: /api/stroke-assessment
- Header: x-access-token
- Request Body:

  - `"idUsers"`: `'num'` (Auto fill with userId),
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
  "status": 201,
  "message": "StrokeAssessment created successfully",
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

## Stroke Assessment History Delete

- Method: DELETE
- Endpoint: /api/stroke-assessment-history/:id
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "message": "Stroke Assessment was deleted successfully!",
  "id": 13
}
```

## Food Recommendation

- Method: POST
- Endpoint: /api/food-recommendation
- Header: x-access-token
- Request Body:

  - `"idStrokeAssessment"`: `'num'`
  - `"namaMakanan"`: `'string'`
  - `"kandungan1"`: `'num'`
  - `"kandunganN"`: `'num'`
  - `"keterangan"`: `'string'`
  - `"fotoMakanan"`: `'string'`

- Response:

```json
{
  "status": 201,
  "message": "FoodRecommendation added successfully",
  "data": {
    "id": 24,
    "idStrokeAssessment": 2,
    "namaMakanan": "Roti Manis",
    "kandungan1": 12.12,
    "kandunganN": 9.11,
    "keterangan": "Lorem Ipsum Sit Amet Dolor",
    "fotoMakanan": "https://linkbucketnya-mungkin",
    "updatedAt": "2023-12-16T07:23:26.162Z",
    "createdAt": "2023-12-16T07:23:26.162Z"
  }
}
```

## Food Recommendation History

- Method: GET
- Endpoint: /api/food-recommendation-history/:strokeAssessmentId
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": [
    {
      "id": 6,
      "idStrokeAssessment": 2,
      "namaMakanan": "Roti Pangsit",
      "kandungan1": 12.12,
      "kandunganN": 9.11,
      "keterangan": "Lorem Ipsum Sit Amet Dolor",
      "fotoMakanan": "https://linkbucketnya-mungkin",
      "createdAt": "2023-12-16T04:03:01.000Z",
      "updatedAt": "2023-12-16T04:03:01.000Z"
    },
    {
      "id": 7,
      "idStrokeAssessment": 2,
      "namaMakanan": "Roti Kari",
      "kandungan1": 12.12,
      "kandunganN": 9.11,
      "keterangan": "Lorem Ipsum Sit Amet Dolor",
      "fotoMakanan": "https://linkbucketnya-mungkin",
      "createdAt": "2023-12-16T04:03:04.000Z",
      "updatedAt": "2023-12-16T04:03:04.000Z"
    }
  ]
}
```

## Food Recommendation Delete

- Method: DELETE
- Endpoint: /api/food-recommendation-history/:id
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "message": "Food Recommendation was deleted successfully!",
  "id": 26
}
```

## Health Education Preview

- Method: GET
- Endpoint: /api/health-education
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": [
    {
      "judulArtikel": "Sample Title",
      "tanggal": "2023-12-15",
      "penerbit": "Publisher Name"
    },
    {
      "judulArtikel": "Sample Title",
      "tanggal": "2023-12-15",
      "penerbit": "Publisher Name"
    },
    {
      "judulArtikel": "Sample Title",
      "tanggal": "2023-12-15",
      "penerbit": "Publisher Name"
    }
  ]
}
```

## Health Education Detail

- Method: GET
- Endpoint: /api/health-education/:id
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": {
    "id": 2,
    "judulArtikel": "Sample Title",
    "isiArtikel": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla vel enim faucibus consectetur eu et quam. \n\nMorbi quis vehicula libero. Cras vulputate condimentum eros, eu consectetur tortor.",
    "tanggal": "2023-12-15",
    "penerbit": "Publisher Name",
    "penulis": "Author Name",
    "fotoArtikel": "https://example.com/image.jpg",
    "createdAt": "2023-12-17T07:12:05.000Z",
    "updatedAt": "2023-12-17T07:12:05.000Z"
  }
}
```
