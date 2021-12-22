def call(target) {
	sh """
		pushd aosp

		source build/envsetup.sh
		lunch ${target}
		m

		popd
	"""
}
