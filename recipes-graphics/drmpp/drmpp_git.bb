#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "drmpp library with examples"
AUTHOR = "The drmpp contributors"
HOMEPAGE = "https://github.com/jwinarske/drmpp"
BUGTRACKER = "https://github.com/jwinarske/drmpp/issues"
SECTION = "graphics"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2345fa5ec49b5e92a916999c585d7f6d"

DEPENDS += "\
    libdrm \
    libinput \
    systemd \
    libxkbcommon \
   "

REQUIRED_DISTRO_FEATURES = "systemd"

SRCREV = "12cd6e510c8724be285fd78999d7ce3e559b3f67"
SRC_URI = "\
    gitsm://github.com/jwinarske/drmpp.git;lfs=0;protocol=https;destsuffix=git;branch=dev \
    file://keymap_us_pc105.xkb \
    "

S = "${WORKDIR}/git"

inherit features_check pkgconfig meson

PACKAGECONFIG ??= "examples"

PACKAGECONFIG[examples] = "-Dexamples=true -Ddefault_library=static, -Dexamples=false"

do_install:append() {
    rm -rf ${D}${bindir}/di-edid-decode

    install -D -m 0644 ${WORKDIR}/keymap_us_pc105.xkb ${D}/home/root/.xkb/keymap.xkb
}

FILES:${PN} += " /home/*"
