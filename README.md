# Biblioteca
[![](https://jitpack.io/v/padamchopra/Biblioteca.svg)](https://jitpack.io/#padamchopra/Biblioteca)

A library to showcase compose components and edit theme at run-time

## Getting Started

- Add jitpack as a source to your project level `build.gradle`
```gradle
buildScript {
  ..
  repositories {
      ..
      maven{ url 'https://jitpack.io' }
  }
}
```
- Add Biblioteca as a dependency in the `build.gradle` for the module (example: `:app`) from where you want to launch it
```gradle
dependencies {
  ..
  implementation 'com.github.padamchopra:Biblioteca:v$biblioteca_version'
}
```
- Replace `{$biblioteca_version}` with the latest version you see in the jitpack badge. For example:
```gradle
dependencies {
  ..
  implementation 'com.github.padamchopra:Biblioteca:v0.1'
}
```

## Usage
- Refer to the `:app` module of this project to view a sample implementation
