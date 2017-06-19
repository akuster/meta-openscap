SUMMARY = "Implementation of fts(3) for musl libc packages in Void Linux"
LIC_FILES_CHKSUM = "file://COPYING;md5=5ffe358174aad383f1b69ce3b53da982"
LICENSE = "BSD-3-Clause"
HOMEPAGE = "https://github.com/pullmoll/musl-fts"

SRCREV = "0bde52df588e8969879a2cae51c3a4774ec62472"
SRC_URI = "git://github.com/pullmoll/musl-fts.git"

S = "${WORKDIR}/git"

inherit autotools-brokensep pkgconfig

do_configure_prepend () {
	cd ${S}
	./bootstrap.sh
}
