SUMMARY = "API Documentations, HowTos and Tutorials"
AUTHOR = "David Rheinsberg"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

DEPENDS += "\
    libdrm \
"

SRCREV = "815de035b291cfdf3c858d4420482ffa42c878a1"

SRC_URI = "\
    git://github.com/dvdhrm/docs.git;protocol=https;branch=master \
    file://0001-remove-Makefile.patch \
    file://meson.build \
    "

S = "${UNPACKDIR}/git"

do_configure:prepend() {
    mv ${UNPACKDIR}/meson.build ${S}/
}

inherit pkgconfig meson
