def call(clean_build) {
	sh """
		if [ "${clean_build}" == "true" ]; then
			if [ -d aosp ]; then
				pushd aosp
				source build/envsetup.sh
				m clean
				repo forall -c git clean -xdf
				popd
			fi
		fi
	"""
}
