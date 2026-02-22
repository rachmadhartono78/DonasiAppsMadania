# Review & Rencana Modernisasi DonasiAppsMadania

Berdasarkan analisis kode tahun 2021, berikut adalah poin-poin review dan rencana pengerjaan (Improvement):

## 1. UI/UX Modernization (Material Design 3)
*   **Masalah:** Masih menggunakan `AppCompat` dan library pihak ketiga untuk navigasi yang sudah jarang di-update (`AnimatedBottomBar`).
*   **Solusi:** Migrasi ke **Material Design 3 (Material You)**. Gunakan komponen standar Google yang lebih stabil.
*   **Aksi:** 
    *   Update library `com.google.android.material:material` ke versi terbaru.
    *   Ganti `AnimatedBottomBar` dengan `BottomNavigationView` dari Material Design.
    *   Sederhanakan navigasi: Hilangkan `DrawerLayout` yang redundan, fokus pada `BottomNavigation`.

## 2. Refactoring Kode (Modern Android Development - MAD)
*   **Masalah:** Kode masih menggunakan Java, `findViewById`, dan belum menerapkan *Architecture Components*.
*   **Solusi:** Implementasi **ViewBinding** dan (opsional tapi disarankan) migrasi bertahap ke **Kotlin**.
*   **Aksi:**
    *   Aktifkan `viewBinding` di `build.gradle`.
    *   Ganti `findViewById` di `MainActivity` dengan ViewBinding untuk keamanan tipe data.

## 3. Update Dependensi & SDK
*   **Masalah:** SDK dan library sudah tertinggal (Target SDK 30).
*   **Solusi:** Update ke Target SDK 34 (Android 14) untuk keamanan dan performa terbaik.
*   **Aksi:** Update `compileSdkVersion`, `targetSdkVersion`, dan versi library Firebase/Midtrans.

## 4. Fitur Baru & Peningkatan Fungsionalitas
*   **Aksi:**
    *   Rencana penambahan "Login with Google".
    *   Perbaikan alur pembayaran Midtrans agar lebih *seamless*.
