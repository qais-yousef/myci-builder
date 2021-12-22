def call(target, buildtype) {
	sh """
		pushd aosp

		source build/envsetup.sh
		lunch ${target}-${buildtype}
		m

		popd
	"""
}
