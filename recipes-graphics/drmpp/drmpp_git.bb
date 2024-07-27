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

SRCREV = "742eb826aceec97ef66d74691a4e6d61bbfb1f07"
SRC_URI = "\
    gitsm://github.com/jwinarske/drmpp.git;lfs=0;protocol=https;destsuffix=git;branch=dev \
    file://keymap_us_pc105.xkb \
    "

S = "${WORKDIR}/git"

inherit features_check pkgconfig meson

KEYMAP_FILE ??= "${WORKDIR}/keymap_us_pc105.xkb"
DEFAULT_USER ??= "root"

PACKAGECONFIG ??= "examples"

PACKAGECONFIG[examples] = "-Dexamples=true -Ddefault_library=static, -Dexamples=false"

do_install:append() {
    rm -rf ${D}${bindir}/di-edid-decode

    install -D -m 0644 ${KEYMAP_FILE} ${D}/home/${DEFAULT_USER}/.xkb/keymap.xkb
}

EXTRA_OEMESON += " -Dexamples=true -Ddefault_library=static"

FILES:${PN} += " /home/*"
