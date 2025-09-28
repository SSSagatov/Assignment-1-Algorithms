📊 Report: Divide-and-Conquer Algorithms 🧠
🏗️ Architecture Notes

The algorithms were implemented with safe recursion patterns and efficient memory management. Here’s a breakdown of how recursion depth and memory allocations were controlled:

MergeSort 🔄:

The array is recursively split into two halves, and each half is sorted. This results in a recursion depth of O(log n).

A reusable buffer was used for merging to minimize memory allocations, so space complexity is O(n).

Small-n cut-off: For subarrays with fewer than 20 elements, Insertion Sort is used to avoid deep recursion and minimize overhead.

QuickSort 🔀:

We used smaller-first recursion to ensure the stack remains shallow, with a typical recursion depth of O(log n).

The pivot is chosen randomly, ensuring that the recursion depth is balanced on average. This leads to a bounded stack that is typical for QuickSort.

Deterministic Select (Median-of-Medians) 🧮:

The partitioning is done in-place, with in-place partitioning ensuring minimal additional memory usage.

The recursion depth is O(log n), as the algorithm always recurses into the smaller side of the partition.

Closest Pair of Points (2D, O(n log n)) 📍:

Divide-and-conquer was used to recursively split the points and perform the merge step.

The recursion depth is kept low due to the use of efficient geometric partitioning.

📐 Recurrence Analysis
1. MergeSort (D&C, Master Case 2) 🔗

Recurrence:

𝑇
(
𝑛
)
=
2
𝑇
(
𝑛
2
)
+
𝑂
(
𝑛
)
T(n)=2T(
2
n
	​

)+O(n)

Master Theorem 📚:
This recurrence fits Master Case 2 where 
𝑎
=
2
a=2, 
𝑏
=
2
b=2, and 
𝑑
=
1
d=1.
Therefore, the time complexity is Θ(n log n).

2. QuickSort (Robust) 🔀

Recurrence:

𝑇
(
𝑛
)
=
𝑇
(
𝑛
/
2
)
+
𝑂
(
𝑛
)
T(n)=T(n/2)+O(n)

Akra-Bazzi Intuition 🧠:
The algorithm uses a randomized pivot, which helps divide the array into two approximately equal halves. The time complexity is Θ(n log n) on average, as the depth of recursion is balanced, leading to logarithmic recursion depth.

3. Deterministic Select (Median-of-Medians) 🧮

Recurrence:

𝑇
(
𝑛
)
=
𝑇
(
𝑛
/
5
)
+
𝑂
(
𝑛
)
T(n)=T(n/5)+O(n)

Master Theorem 🏆:
This recurrence corresponds to Θ(n) because the size of the problem reduces by a factor of 5 at each recursion level, and each step takes linear time for partitioning.

4. Closest Pair of Points (2D, O(n log n)) 📍

Recurrence:

𝑇
(
𝑛
)
=
2
𝑇
(
𝑛
/
2
)
+
𝑂
(
𝑛
)
T(n)=2T(n/2)+O(n)

Master Theorem 📐:
Like MergeSort, this follows the same recurrence, so the time complexity is Θ(n log n). The merge step, which sorts the points by their y-coordinate, dominates the computation.

📈 Plots and Measurements
1. Time vs. n ⏱️

MergeSort and QuickSort both exhibit Θ(n log n) behavior, with QuickSort typically performing faster due to in-place partitioning.

Deterministic Select showed a linear increase in time, as expected for Θ(n).

Closest Pair of Points followed the same pattern as MergeSort and QuickSort, with time complexity Θ(n log n).

2. Recursion Depth vs. n 📉

MergeSort showed a logarithmic growth in recursion depth (O(log n)).

QuickSort maintained a bounded stack, with recursion depth typically O(log n) on average.

Deterministic Select also followed O(log n) recursion depth, as the algorithm always recurses into the smaller partition.

Closest Pair of Points exhibited a shallow recursion depth due to efficient geometric partitioning.

Discussion of Constant-Factor Effects:

Cache and Memory Effects:
The algorithms' performance can be affected by cache locality and memory usage. For instance, QuickSort performs better with in-place partitioning because it reduces memory overhead. In contrast, MergeSort requires more memory due to the reusable buffer used during the merging phase.

Garbage Collection:
Java's garbage collection might slightly affect performance during recursion due to the frequent creation of temporary arrays. This is particularly noticeable in algorithms like MergeSort and Closest Pair of Points, where additional arrays are allocated during each recursive call.

📋 Summary: Alignment Between Theory and Measurements

MergeSort and QuickSort both adhered closely to their Θ(n log n) theoretical time complexities, with QuickSort showing a faster constant factor due to the randomized pivot and in-place partitioning.

Deterministic Select performed as expected with Θ(n) time complexity, and recursion depth was minimal.

Closest Pair of Points also performed in Θ(n log n) time, with slight overhead from the strip check. The algorithm performed well for large datasets with efficient recursion depth.

📢 Conclusion

The algorithms demonstrated strong alignment between theoretical predictions and measured performance. Constant factors such as cache locality, memory allocations, and garbage collection affected the practical performance but did not deviate from the expected time complexities.
