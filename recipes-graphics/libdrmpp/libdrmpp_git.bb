#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "drmpp library with examples"
AUTHOR = "The drmpp contributors"
HOMEPAGE = "https://github.com/jwinarske/drmpp"
BUGTRACKER = "https://github.com/jwinarske/drmpp/issues"
SECTION = "graphics"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a8441068174c9a128f4725c984d99c20"

DEPENDS += "\
    cmake-native \
    libdrm \
    libinput \
    libxkbcommon \
    systemd \
    virtual/libgbm \
    "

RDEPENDS:${PN} = "\
    libdrm \
    "

REQUIRED_DISTRO_FEATURES = "systemd"

SRCREV = "29be5876e5d2245a8bde114e446cb0edb78d4d99"
SRC_URI = "\
    gitsm://github.com/jwinarske/drmpp.git;lfs=0;protocol=https;destsuffix=git;branch=dev \
    "

S = "${UNPACKDIR}/git"

inherit features_check pkgconfig meson

PACKAGECONFIG ??= "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'examples', '', d)} \
    lvgl-examples \
    ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'vulkan', '', d)} \
"

PACKAGECONFIG[examples] = "-Dexamples=true, -Dexamples=false, virtual/egl virtual/libgles2 virtual/libgl"
PACKAGECONFIG[lvgl-examples] = "-Dlvgl-examples=true, -Dlvgl-examples=false"
PACKAGECONFIG[vulkan] = "-Dvulkan=true, -Dvulkan=false, vulkan-loader"

do_install:append() {
    rm -rf ${D}${bindir}/di-edid-decode
    rm -rf ${D}${bindir}/edid-decode
    rm -rf ${D}${datadir}/man/man1/edid-decode.1
    rm -rf ${D}${includedir}/libdisplay-info
    rm -rf ${D}${includedir}/libliftoff.h
    rm -rf ${D}${libdir}/libdisplay-info.a
    rm -rf ${D}${libdir}/libliftoff.a
    rm -rf ${D}${libdir}/pkgconfig/libdisplay-info.pc
    rm -rf ${D}${libdir}/pkgconfig/libliftoff.pc
}
