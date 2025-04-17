# AddressBuilder Java Application

## Description
The AddressBuilder program prompts a user for their full name, billing address, and shipping address. It utilizes `StringBuilder` to construct and display the collected address information in a formatted way.

## Features
- Uses `StringBuilder` for efficient string concatenation.
- Prompts for full name, billing address, and shipping address.
- Displays the collected and formatted address information.

## Sample Input
Full name: Grover Smith  
Billing Street: 123 Main Street  
Billing City: Middleton  
Billing State: TX  
Billing Zip: 75111  
Shipping Street: 456 Big Sky Blvd  
Shipping City: Outer Rim  
Shipping State: TX  
Shipping Zip: 75333

## Sample Output

Grover Smith

Billing Address:  
123 Main Street  
Middleton, TX 75111

Shipping Address:  
456 Big Sky Blvd  
Outer Rim, TX 75333

## How to Run
Compile and run using your terminal or IDE:

```bash
javac AddressBuilder.java
java AddressBuilder
