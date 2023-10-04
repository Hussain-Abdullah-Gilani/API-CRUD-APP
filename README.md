# Android CRUD App README


![Android](https://img.shields.io/badge/kotlin-purple)


## Introduction

Welcome to the Android CRUD (Create, Read, Update, Delete) App! This Android application provides a simple interface for managing a collection of items, allowing users to perform CRUD operations on them. Powered by [JSONPlaceholder](https://jsonplaceholder.typicode.com/)

## Table of Contents

1. [Features](#features)
2. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
3. [Usage](#usage)
   - [Creating an Item](#creating-an-item)
   - [Reading an Item](#reading-an-item)
   - [Updating an Item](#updating-an-item)
   - [Deleting an Item](#deleting-an-item)
4. [Contributing](#contributing)
5. [License](#license)

## Features

- Create new items with a title and description.
- View a list of all items in a user-friendly interface.
- Update the title and description of existing items.
- Delete items from the list.
- Responsive user interface with smooth animations.
- Error handling for a seamless user experience.

## Getting Started

### Prerequisites

Before you begin, ensure you have met the following requirements:

- Android Studio installed on your development machine.
- Basic knowledge of Android app development.
- An Android device or emulator for testing.

### Installation

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/android-crud-app.git
   ```

2. Open the project in Android Studio.

3. Install important dependencies
   ```bash
    implementation 'androidx.core:core-ktx:1.7.0'
    implementation 'androidx.appcompat:appcompat:1.5.0'
    implementation 'com.google.android.material:material:1.6.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    implementation 'androidx.navigation:navigation-fragment-ktx:2.5.1'
    implementation 'androidx.navigation:navigation-ui-ktx:2.5.1'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-moshi:2.9.0"
    implementation "com.squareup.okhttp3:okhttp:4.9.0"
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
    implementation 'com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0'
    compileOnly "com.squareup.retrofit2:adapter-rxjava2:2.3.0"
   ```

5. Build and run the app on your Android device or emulator.

## Usage

### Creating an Item

1. Launch the app.
2. Click the "Add" button or the plus icon to create a new item.
3. Enter a title and description for the item.
4. Click the "Save" button to add the item to the list.

### Reading an Item

1. Open the app.
2. You will see a list of existing items.
3. Tap on an item to view its details.

### Updating an Item

1. Open the app.
2. Tap on an item in the list to view its details.
3. Click the "Edit" button.
4. Update the title and description as needed.
5. Click the "Save" button to save the changes.

### Deleting an Item

1. Open the app.
2. Tap on an item in the list to view its details.
3. Click the "Delete" button.
4. Confirm the deletion when prompted.

## Contributing

We welcome contributions from the community! If you'd like to contribute to the project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and test them thoroughly.
4. Create a pull request to merge your changes into the main branch.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

Thank you for using the Android CRUD App! If you have any questions or encounter any issues, please don't hesitate to [open an issue](https://github.com/yourusername/android-crud-app/issues). Happy coding!
