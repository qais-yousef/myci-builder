def call() {
	sh """
		if [ -d aosp ]; then
			pushd aosp
			source build/envsetup.sh
			m clean
			repo forall -c git clean -xdf
			popd
		fi
	"""
}
