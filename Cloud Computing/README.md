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

  - `"idUsers"`: `'int'` (Auto fill with userId),
  - `"nama"`: `'string'`
  - `"usia"`: `'int'`
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

## Generate Food Recommendation

- Method: GET
- Endpoint: /api/food-recommendation/:strokeAssessmentId
- Header: x-access-token

- Response:

```json
{
  "status": 200,
  "data": {
    "Kalium": 0.14,
    "Karbohidrat": 4.8,
    "Keterangan": "Daun Singkong Rebus adalah sayuran yang dimasak dengan cara direbus.",
    "Lemak": 0.6,
    "Link": "https://www.bantennews.co.id/wp-content/uploads/2019/06/Screenshot_2019-06-16-00-14-40-190_org.detikcom.rss_.jpg",
    "Nama Makanan": "Daun Singkong Rebus",
    "Natrium": 0.13,
    "Serat": 1.6
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
      "id": 1,
      "idStrokeAssessment": 1,
      "namaMakanan": "Daun Singkong Rebus",
      "lemak": 0.6,
      "karbohidrat": 4.8,
      "natrium": 0.13,
      "kalium": 0.14,
      "serat": 1.6,
      "keterangan": "Daun Singkong Rebus adalah sayuran yang dimasak dengan cara direbus.",
      "link": "https://www.bantennews.co.id/wp-content/uploads/2019/06/Screenshot_2019-06-16-00-14-40-190_org.detikcom.rss_.jpg",
      "createdAt": "2023-12-21T09:54:43.000Z",
      "updatedAt": "2023-12-21T09:54:43.000Z"
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
  "id": 3
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
      "id": 1,
      "judulArtikel": "Sample Title 1",
      "tanggal": "15-12-2023",
      "penerbit": "Publisher Name 1",
      "fotoArtikel": "https://example.com/image1.jpg"
    },
    {
      "id": 2,
      "judulArtikel": "Sample Title 2",
      "tanggal": "16-12-2023",
      "penerbit": "Publisher Name 2",
      "fotoArtikel": "https://example.com/image2.jpg"
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
    "judulArtikel": "Sample Title 2",
    "isiArtikel": "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed et nulla vel enim faucibus consectetur eu et quam. \n\nMorbi quis vehicula libero. Cras vulputate condimentum eros, eu consectetur tortor.",
    "tanggal": "16-12-2023",
    "penerbit": "Publisher Name 2",
    "penulis": "Author Name 2",
    "fotoArtikel": "https://example.com/image2.jpg",
    "createdAt": "2023-12-17T07:12:05.000Z",
    "updatedAt": "2023-12-17T07:12:05.000Z"
  }
}
```
