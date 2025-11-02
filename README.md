# Pagination, Sorting & Filtering Practice

This is a small Spring Boot project demonstrating **Pagination, Sorting, and Filtering** for a simple `Product` entity.

## Product Entity

Each product has the following fields:

- **id**: Unique identifier for the product
- **name**: Name of the product
- **category**: Category of the product (e.g., Laptop, Mobile)
- **price**: Price of the product

Example:

```json
{
  "id": 1,
  "name": "Acer Laptop",
  "category": "Laptop",
  "price": 980000
}

Features

Pagination - Load data in pages instead of all at once.
Example: /api/products?page=0&size=5 – gets the first 5 products.

Sorting - Arrange products by a field in ascending or descending order.
Example: /api/products?sort=price,asc – sorts products by price low to high.

Filtering - Filter products by category, price range, or other fields.
Example: /api/products?category=Laptop&minPrice=50000&maxPrice=1000000

How to Run
1. Clone the repository:
git clone https://github.com/Mahesh-Khadka/pagination-sorting-filtering-practice.git
cd pagination-sorting-filtering-practice

2. Build and run the Spring Boot application:
./mvnw spring-boot:run

Technologies Used

Java 17

Spring Boot

Spring Data JPA

MYSQL
