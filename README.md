# admin-dashboard
Admin Dashboard Application

- Login username: *admin*
- Login password: *admin*

Local environment setup: 
1. Download source code from *https://github.com/jonhendrik/admin-dashboard*
2. Import as Maven Project
3. Update Maven Project
4. Run com.jhm.admdash.AdmdashApplication.java as Java Application

Frontend Technology used as required
- JSP
- Bootstrap v3

Backend
- Java Springboot
- H2 Database - since it is an open source embedded in-memory database, but can also be used persistent by saving it through a file. (db/admdashdb.mv.db in source code)

Entities
- Account - contains account data
- Customer - contains customer data
- Invoice - contains invoice data
- User - for user login accounts

APIs
- POST localhost:8000/auth
- GET localhost:8000/api/accounts
- GET localhost:8000/api/customers/:id
- POST localhost:8000/api/customers
- PUT localhost:8000/api/customers/:id
- DELETE localhost:8000/api/customers/:id
- GET localhost:8000/api/invoices/:id
- POST localhost:8000/api/invoices
- PUT localhost:8000/api/invoices/:id
- DELETE localhost:8000/api/invoices/:id