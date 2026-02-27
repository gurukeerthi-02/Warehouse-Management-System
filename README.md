# Warehouse Inventory Management

A full-stack inventory management system for warehouse operations.

## Tech Stack

- Frontend: Angular with TypeScript
- Backend: Java (Spring Boot)
- API: REST

## Features

- Add new products with name, price, and quantity
- View all products in inventory
- Search products by name
- Delete products from inventory
- Buy stock functionality
- Real-time inventory calculations
- Toast notifications for user feedback

## Setup

### Backend
1. Navigate to the backend directory
2. Run the Spring Boot application on port 8080

### Frontend
1. Navigate to `frontend/warehouse-management`
2. Install dependencies: `npm install`
3. Start the development server: `ng serve`
4. Open browser at `http://localhost:4200`

## API Endpoints

- GET `/fetchProducts` - Retrieve all products
- POST `/products` - Add a new product
- DELETE `/deleteProduct/{id}` - Delete a product
- PATCH `/buyStock/{id}` - Purchase stock

## Project Structure

```
Warehouse_Inventory_Management/
├── frontend/
│   └── warehouse-management/
└── backend/
```
