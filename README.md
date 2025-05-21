# Makerspace Knickknack Simulator

A Java concurrency simulation for managing a small-scale makerspace, where multiple makers (threads) attempt to produce various knickknacks using shared stations/tools.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Knickknacks & Recipes](#knickknacks--recipes)
- [Requirements](#requirements)
- [How to Run](#how-to-run)
- [Sample Output](#sample-output)
- [Diagrams](#diagrams)
- [Technologies Used](#technologies-used)
- [Author](#author)

---

## 🧠 Overview

This project simulates a concurrency-heavy environment inspired by a real-world makerspace. Each knickknack has a defined workflow (or "recipe") involving multiple stations. Each station can only be used by one thread at a time, requiring proper synchronization to avoid race conditions and deadlocks.

The user can:
- Select which knickknacks to produce
- Specify how many of each to make
- Set how often progress updates are shown

---

## 🛠️ Features

- Multi-threaded simulation using Java threads
- Custom locking mechanisms to manage station access
- Dynamic user input for task selection and iteration count
- Configurable progress reporting interval
- Resource allocation and deadlock handling diagrams created using Draw.io
- Clean separation of logic for each knickknack/task type

---

## 🧩 Knickknacks & Recipes

Each knickknack follows a strict sequence of station usage. For example:

- **Chess Set**
  1. Print white pieces – Resin Printer
  2. Lathe white rooks – Lathe
  3. Print black pieces – Resin Printer
  4. Lathe black rooks – Lathe
  5. Print board – FDM Printer
  6. Package set

- **Toaster Pastry**
  1. Bake – Toaster Oven
  2. Cool & Eat – Simulated steps (no station)

- **Flashlight**
  1. Hollow body – Lathe
  2. Drill holes – Mill
  3. Solder circuit – Soldering Iron

And many more…

---

## 💻 Requirements

- Java 11+
- IntelliJ IDEA (preferred IDE)
- No external libraries required
- Draw.io for diagram creation

---

## ▶️ How to Run

1. Clone this repo:
   ```bash
   git clone https://github.com/YOUR_USERNAME/makerspace-simulator.git
   cd makerspace-simulator
