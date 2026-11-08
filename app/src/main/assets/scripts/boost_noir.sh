#!/system/bin/sh
# ============================================================
#  boost_noir.sh — Noir x boost (by CENTRALVEX)
#  Dieksekusi via: su -c ./boost_noir.sh
#  Kompatibel: Android 10–15, Snapdragon / MediaTek / Exynos
# ============================================================

LOG_TAG="NoirBoost"
log() { echo "[$LOG_TAG] $1"; }

log "=============================="
log " Noir x boost — Start"
log "=============================="

# 1. Kill background apps
log "[1/8] Menutup proses background..."
am kill-all 2>/dev/null

# 2. Android Game Mode
log "[2/8] Mengaktifkan Game Mode..."
cmd game mode 2 2>/dev/null || true

# 3. Percepat animasi sistem
log "[3/8] Mempercepat animasi sistem..."
settings put global window_animation_scale 0.5
settings put global transition_animation_scale 0.5
settings put global animator_duration_scale 0.5

# 4. Optimasi touch response
log "[4/8] Optimasi respons sentuh..."
cmd device_config put input_native_boot palm_rejection_enabled 0 2>/dev/null

# 5. Bebaskan RAM
log "[5/8] Membebaskan RAM..."
sync
echo 3 > /proc/sys/vm/drop_caches 2>/dev/null

# 6. Sustained performance mode
log "[6/8] Mengaktifkan sustained performance mode..."
settings put global sustained_performance_mode 1 2>/dev/null

# 7. Thermal control (jaga suhu stabil, tidak mematikan proteksi perangkat secara permanen)
log "[7/8] Menyesuaikan profil thermal..."
setprop vendor.thermal.mode.boost 1 2>/dev/null

# 8. Selesai
log "[8/8] Noir x boost selesai dijalankan."
log "=============================="
