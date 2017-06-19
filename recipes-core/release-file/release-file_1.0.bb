inherit allarch

SUMMARY = "Operating release identification"
DESCRIPTION = "The /etc/openembedded-release file contains operating system identification data."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
INHIBIT_DEFAULT_DEPS = "1"

do_fetch[noexec] = "1"
do_unpack[noexec] = "1"
do_patch[noexec] = "1"
do_configure[noexec] = "1"

OE_RELEASE_FIELDS = "VERSION PRETTY_NAME"

VERSION = "0"
PRETTY_NAME = "${DISTRO_NAME} ${VERSION}"

def sanitise_version(ver):
    ret = ver.replace('+', '-').replace(' ','_')
    return ret.lower()

python do_compile () {
    import shutil
    with open(d.expand('${B}/openemebedded-release'), 'w') as f:
        for field in d.getVar('OE_RELEASE_FIELDS', True).split():
            value = d.getVar(field, True)
            if value:
                f.write('{0}="{1}"\n'.format(field, value))
}
do_compile[vardeps] += "${OE_RELEASE_FIELDS}"

do_install () {
    install -d ${D}${sysconfdir}
    install -m 0644 openemebedded-release ${D}${sysconfdir}/
}
