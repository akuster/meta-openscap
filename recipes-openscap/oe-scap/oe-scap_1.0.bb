# Copyright (C) 2017 Armin Kuster  <akuster808@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

SUMARRY = "OE SCAP files"
LIC_FILES_CHKSUM = "file://README.md;md5=46dec9f167b6e05986cb4023df6d92f4"
LICENSE = "MIT"

SRCREV = "7147871d7f37d408c0dd7720ef0fd3ec1b54ad98"
SRC_URI = "git://github.com/akuster/oe-scap.git"
SRC_URI += "file://run_cve.sh"

S = "${WORKDIR}/git"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
	install -d ${D}/${datadir}/oe-scap
	cp ${S}/* ${D}/${datadir}/oe-scap/.
}

FILES_${PN} += "${datadir}/oe-scap"
