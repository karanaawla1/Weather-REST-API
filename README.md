# 🌤️ Weather REST API

A Spring Boot REST API that fetches **real-time weather data** for any city using the OpenWeatherMap API.

---

## 🚀 Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot 3.4.x | Web framework |
| Maven | Build tool |
| OpenWeatherMap API | Weather data source |
| Lombok | Boilerplate reduction |
| REST Template | HTTP client |

---

## 📁 Project Structure

```
weatherapi/
├── src/
│   └── main/
│       ├── java/com/weather/weatherapi/
│       │   ├── controller/
│       │   │   └── WeatherController.java
│       │   ├── service/
│       │   │   └── WeatherService.java
│       │   └── dto/
│       │       └── WeatherResponse.java
│       └── resources/
│           └── application.properties
├── Dockerfile
├── pom.xml
└── README.md
```

---

## ⚙️ Prerequisites

- Java 17+
- Maven 3.9+
- OpenWeatherMap API Key → [Get it here](https://openweathermap.org/api)

---

## 🛠️ Setup & Installation

**1. Clone the repository**

```bash
git clone https://github.com/karanaawla1/Weather-REST-API.git
cd Weather-REST-API
```

**2. Add your API key**

Open `src/main/resources/application.properties` and add:

```properties
spring.application.name=weatherapi
weather.api.key=YOUR_API_KEY_HERE
weather.api.url=https://api.openweathermap.org/data/2.5/weather
```

**3. Run the application**

```bash
.\mvnw.cmd spring-boot:run       # Windows
./mvnw spring-boot:run           # macOS / Linux
```

The server will start at: `http://localhost:8080`

---

## 📡 API Endpoints

### Get Weather by City

```
GET /api/weather?city={cityName}
```

**Example Request:**

```
GET http://localhost:8080/api/weather?city=Hyderabad
```

**Example Response:**

```json
{
  "city": "Hyderabad",
  "country": "IN",
  "temperature": 26.44,
  "feelsLike": 26.44,
  "humidity": 45,
  "description": "scattered clouds",
  "icon": "03d"
}
```

**More Examples:**

```
GET http://localhost:8080/api/weather?city=Mumbai
GET http://localhost:8080/api/weather?city=Delhi
GET http://localhost:8080/api/weather?city=London
GET http://localhost:8080/api/weather?city=New York
```

---

## 🐳 Docker Support

Build and run with Docker:

```bash
# Build image
docker build -t weather-rest-api .

# Run container
docker run -p 8080:8080 weather-rest-api
```

---

## 🧪 Testing with Postman

1. Open Postman
2. Set method to **GET**
3. Enter URL: `http://localhost:8080/api/weather?city=Hyderabad`
4. Click **Send**
5. You should receive a `200 OK` response with weather data

---

## 📦 Response Fields

| Field | Type | Description |
|---|---|---|
| `city` | String | City name |
| `country` | String | Country code (e.g. IN, US) |
| `temperature` | Double | Temperature in Celsius |
| `feelsLike` | Double | Feels like temperature in Celsius |
| `humidity` | Integer | Humidity percentage |
| `description` | String | Weather condition description |
| `icon` | String | Weather icon code |

---

## 👨‍💻 Author

**Karan Aawla**
- GitHub: [@karanaawla1](https://github.com/karanaawla1)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
