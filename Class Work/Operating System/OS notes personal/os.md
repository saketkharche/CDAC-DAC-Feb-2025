# **Operating System - Memory Management Detailed Notes**

## **1️⃣ Fixed-Size Partitioning**
### **Definition:**
Fixed-size partitioning is a **memory management technique** where the main memory is divided into **equal-sized partitions** before execution. Each partition can hold **exactly one process**.

### **Key Characteristics:**
✔️ Memory is **divided at system startup**.
✔️ Each partition **holds one process at a time**.
✔️ If a process is smaller than the partition size, **internal fragmentation** occurs.

### **Advantages:**
✅ **Easy to implement** and manage.
✅ **Prevents external fragmentation**.

### **Disadvantages:**
❌ **Leads to internal fragmentation** (unused memory inside allocated partitions).
❌ **Fixed number of partitions** limits the degree of multiprogramming.

### **Example:**
| Partition | Process Loaded | Size Allocated | Unused Space |
|-----------|---------------|---------------|--------------|
| P1 | Process A (3 MB) | 5 MB | 2 MB |
| P2 | Process B (5 MB) | 5 MB | 0 MB |
| P3 | Process C (2 MB) | 5 MB | 3 MB |

Here, **unused memory inside partitions leads to internal fragmentation**.

---

## **2️⃣ Variable-Size Partitioning**
### **Definition:**
Variable-size partitioning is a **dynamic memory allocation** method where partitions are created **based on the size of processes** at runtime.

### **Key Characteristics:**
✔️ Partitions are **not predefined**.
✔️ The OS **allocates memory dynamically**.
✔️ Reduces **internal fragmentation**, but may cause **external fragmentation**.

### **Advantages:**
✅ **Better memory utilization** as partitions fit process sizes.
✅ **More flexible than fixed-size partitioning**.

### **Disadvantages:**
❌ **External fragmentation occurs** (small free spaces scattered across memory).
❌ **Overhead in memory management** due to dynamic partitioning.

### **Example:**
| Process | Size Required | Partition Allocated |
|---------|-------------|----------------|
| P1 | 4 MB | 4 MB |
| P2 | 6 MB | 6 MB |
| P3 | 8 MB | 8 MB |

In this case, **no internal fragmentation occurs** as memory is allocated exactly as needed.

---

## **3️⃣ Fragmentation**
Fragmentation occurs when memory is inefficiently utilized, leading to **wastage of memory**.

### **Types of Fragmentation:**
- **Internal Fragmentation** → Memory **inside** a partition is wasted.
- **External Fragmentation** → Free memory is **scattered**, preventing allocation of large processes.

### **Solution:**
✔️ **Compaction** → Rearranges memory to form large contiguous free blocks.
✔️ **Paging** → Eliminates external fragmentation by using fixed-size pages.

---

## **4️⃣ Paging**
### **Definition:**
Paging is a **memory management scheme** where the OS **divides processes into fixed-size pages** and maps them onto **physical memory frames**.

### **Characteristics:**
✔️ Eliminates **external fragmentation**.
✔️ Requires a **page table** for address translation.
✔️ Fixed **page size (e.g., 4 KB, 8 KB, etc.)**.

### **Page Table Example:**
| Page Number | Frame Number |
|------------|------------|
| 0 | 3 |
| 1 | 7 |
| 2 | 1 |
| 3 | 4 |

**Formula for Address Translation:**
```
Physical Address = (Frame Number × Frame Size) + Offset
```

---

## **5️⃣ Compaction & Defragmentation**
### **Definition:**
Compaction is the process of **shifting memory blocks** to create **contiguous free space**.

### **Characteristics:**
✔️ Helps reduce **external fragmentation**.
✔️ Requires **relocating processes** in memory.
✔️ Can be **time-consuming**.

---

## **6️⃣ Dynamic Partitioning**
### **Definition:**
A method where **partitions are allocated dynamically** based on process size.

### **Characteristics:**
✔️ **No fixed partitions**.
✔️ Reduces **internal fragmentation**.
✔️ May cause **external fragmentation**.

---

## **7️⃣ Memory Allocation Strategies**
| Strategy | Mechanism | Pros | Cons |
|----------|----------|------|------|
| **First Fit** | Allocates the first free block found | Fast | Causes external fragmentation |
| **Best Fit** | Chooses the smallest available block that fits | Reduces internal fragmentation | Slow allocation |
| **Worst Fit** | Allocates the largest available block | Leaves large free spaces | Inefficient |

---

## **8️⃣ Virtual Memory**
### **Definition:**
Virtual Memory is a technique that **extends RAM using disk storage**, allowing processes larger than RAM to execute.

### **Key Features:**
✔️ Uses **paging and demand paging**.
✔️ Increases **multiprogramming**.
✔️ Requires **page replacement algorithms** when memory is full.

---

## **9️⃣ Demand Paging**
### **Definition:**
Only **necessary pages are loaded into RAM**, reducing memory usage.

### **Page Fault Handling Steps:**
1️⃣ Process requests a page.
2️⃣ OS checks if the page is in RAM.
3️⃣ If **not in RAM**, a **page fault** occurs.
4️⃣ OS loads the page from disk.

---

## **🔟 Page Replacement Algorithms**
| Algorithm | Mechanism | Pros | Cons |
|-----------|----------|------|------|
| **FIFO** | Replaces the oldest page | Simple | Causes Belady’s Anomaly |
| **LFU** | Replaces least-used page | Efficient | Complex tracking |
| **MRU** | Replaces most recently used page | Fast in some cases | Not always optimal |

### **Belady’s Anomaly**:
- In **FIFO**, increasing page frames **may increase page faults** instead of reducing them.

---

## **🔟 Segmentation**
### **Definition:**
Memory is divided into **logical segments** such as **code, data, and stack**.

### **Segment Table Example:**
| Segment Number | Base Address | Limit |
|------------|--------------|------|
| Code | 0x1000 | 0x0FFF |
| Data | 0x2000 | 0x0FFF |
| Stack | 0x3000 | 0x0FFF |

**Address Translation Formula:**
```
Physical Address = Base Address + Offset
```

---

## **📌 Summary**
✔ **Fixed vs. Variable Partitioning** → Fixed causes internal fragmentation, Variable causes external fragmentation.
✔ **Paging vs. Segmentation** → Paging eliminates external fragmentation, Segmentation organizes memory logically.
✔ **Page Replacement Algorithms** → FIFO, LFU, MRU used to manage Virtual Memory.
✔ **Compaction & Defragmentation** → Used to resolve fragmentation issues.

This document provides **detailed notes** with **examples and formulas**. Let me know if you need additional clarifications or diagrams! 🚀

