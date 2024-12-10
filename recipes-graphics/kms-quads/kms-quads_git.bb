#
# Copyright (c) 2024 Joel Winarske. All rights reserved.
#

SUMMARY = "Straightforward and well-documented KMS example"
AUTHOR = "Daniel Stone"
HOMEPAGE = "https://gitlab.freedesktop.org/daniels/kms-quads"
BUGTRACKER = "https://gitlab.freedesktop.org/daniels/kms-quads/-/issues"
SECTION = "graphics"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b3208c2482121d67a2cc2f235d0980eb"

DEPENDS += "\
    libdrm \
    virtual/libgbm \
"

SRCREV = "b164919285ce90645f4201ce61c3a040001a7bd8"
SRC_URI = "git://gitlab.freedesktop.org/daniels/kms-quads.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

inherit pkgconfig meson

PACKAGECONFIG ??= ""

PACKAGECONFIG[glcore] = "-Dglcore=true, -Dglcore=false"

do_install:append() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/kms-quads ${D}${bindir}/kms-quads
}
