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

SRCREV = "12ab8cdd5d0a82a8ab3e2cc2c78a26d0c65aec0d"
SRC_URI = "\
    gitsm://github.com/jwinarske/drmpp.git;lfs=0;protocol=https;destsuffix=git;branch=dev \
    "

S = "${WORKDIR}/git"

inherit features_check pkgconfig meson

DEFAULT_USER ??= "root"

PACKAGECONFIG ??= "examples"

PACKAGECONFIG[examples] = "-Dexamples=true, -Dexamples=false"

do_install:append() {
    rm -rf ${D}${bindir}/di-edid-decode
}

EXTRA_OEMESON += " -Ddefault_library=static"
