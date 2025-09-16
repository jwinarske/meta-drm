#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "Lightweight KMS plane library."
AUTHOR = "Simon Ser"
HOMEPAGE = "https://gitlab.freedesktop.org/emersion/libliftoff"
BUGTRACKER = "https://gitlab.freedesktop.org/emersion/libliftoff/-/issues"
SECTION = "graphics"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=706cd9899438a9385250ab6773c1fa53"

DEPENDS += "\
    libdrm \
"

SRCREV = "49aec6bb0537be1b63272bfb15317ece42a468d6"
SRC_URI = "git://gitlab.freedesktop.org/emersion/libliftoff.git;protocol=https;branch=master"

inherit pkgconfig meson

do_install:append() {

    install -d ${D}${bindir}/libliftoff
    install -m 0755 ${B}/example/compositor ${D}${bindir}/libliftoff/compositor
    install -m 0755 ${B}/example/dynamic ${D}${bindir}/libliftoff/dynamic
    install -m 0755 ${B}/example/multi-output ${D}${bindir}/libliftoff/multi-output
    install -m 0755 ${B}/example/simple ${D}${bindir}/libliftoff/simple
}
