def call() {
	sh """
		if [ -d aosp ]; then
			pushd aosp
			source build/envsetup.sh
			m clean
			popd
		fi
	"""
}
