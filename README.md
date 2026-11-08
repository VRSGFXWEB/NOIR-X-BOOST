# Noir x boost (by CENTRALVEX) — v2

Project Android baru, ditulis dari nol (Kotlin + Jetpack Compose).
Referensi fitur diambil dari deskripsi APK v1 lo, tapi seluruh kode ditulis ulang.

## Yang sudah dikerjakan
- **Tanpa login**: app langsung masuk dari splash → home, tidak ada Google Sign-In / halaman login.
- **Tanpa iklan**: tidak ada SDK iklan, tidak ada ad-viewer.
- **Tanpa sistem premium/verifikasi**: tidak ada kotak "Pro", koin, atau pengecekan ke server. Semua fitur boost langsung aktif untuk semua user.
- **Tanpa Telegram**: satu-satunya kontak adalah nomor WhatsApp (`6285726893424`) dan saluran WA yang lo kasih.
- **Nama/brand baru**: app name "Noir x boost", package `com.centralvex.noirxboost`, dev name "CENTRALVEX". Tidak ada string "JavaPro" di mana pun.
- **Tema**: merah elegan, gradasi halus (`NoirBackgroundGradient`), efek liquid glass di semua card (`GlassCard.kt`).
- **Splash screen animasi**: fade + scale, lalu otomatis pindah ke Home.
- **Script boost**: ditulis ulang (`assets/scripts/boost_noir.sh`), 8 langkah inti (kill background, game mode, animasi, touch, RAM, sustained performance, thermal). Bagian yang mematikan proteksi thermal perangkat secara permanen sengaja TIDAK disertakan karena bisa merusak hardware dalam jangka panjang.
- **Daftar game** (`assets/scripts/supported_games.txt`) dibawa untuk auto-detect, isinya cuma daftar package name, tidak ada branding lama.

## Yang WAJIB lo lakukan sebelum build
1. **Firebase**: file `app/google-services.json` di project ini masih **placeholder** — config yang lo kasih kemarin itu config Web SDK, bukan Android. Buka Firebase Console → project `xrpl-database` → Add app → Android, masukin package name `com.centralvex.noirxboost`, lalu download `google-services.json` yang asli dan timpa file ini.
2. **Ikon app**: gue taruh ikon sederhana (gradasi merah + huruf "N" emas). Ganti kalau lo punya logo sendiri.
3. **Root permission**: fitur boost butuh akses root (`su`) di device, sama seperti v1. Pastikan device testing lo udah di-root/Magisk.
4. **Build**: buka folder ini di Android Studio (Hedgehog+), biarkan Gradle sync, lalu Run.

## Struktur penting
```
app/src/main/java/com/centralvex/noirxboost/
  MainActivity.kt              -> entry point, navigasi splash/home/contact
  core/BoostRunner.kt          -> eksekusi script boost, tanpa gating
  ui/theme/                    -> warna, gradasi, GlassCard
  ui/screens/
    SplashScreen.kt
    HomeScreen.kt               -> semua fitur boost, tombol "Boost Now"
    ContactScreen.kt            -> WA number + channel saja
app/src/main/assets/scripts/
  boost_noir.sh
  supported_games.txt
```
