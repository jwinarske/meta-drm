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

SRCREV = "8c85a091200c8f2e7ef78355cddadf75e0a296bf"
SRC_URI = "\
    gitsm://github.com/jwinarske/drmpp.git;lfs=0;protocol=https;destsuffix=git;branch=dev \
    "

S = "${WORKDIR}/git"

inherit features_check pkgconfig meson

PACKAGECONFIG ??= "\
    ${@bb.utils.contains('DISTRO_FEATURES', 'opengl', 'examples', '', d)} \
    ${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'vulkan', '', d)} \
"

PACKAGECONFIG[examples] = "-Dexamples=true, -Dexamples=false, virtual/egl virtual/libgles2 virtual/libgl"
PACKAGECONFIG[lvgl-examples] = "-Dlvgl-examples=true, -Dlvgl-examples=false"
PACKAGECONFIG[vulkan] = "-Dvulkan=true, -Dvulkan=false, vulkan-loader"

do_install:append() {
    rm -rf ${D}${bindir}/di-edid-decode
    rm -rf ${D}${includedir}/libdisplay-info/
    rm ${D}${includedir}/libliftoff.h
    rm ${D}${libdir}/libdisplay-info.a
    rm ${D}${libdir}/libliftoff.a
    rm ${D}${libdir}/libspdlog.a
    rm -rf ${D}${libdir}/pkgconfig
}

FILES:${PN}-staticdev += "\
    ${libdir} \
    ${includedir}/drmpp.h \
"