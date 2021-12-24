def call(branch, num_parallel_jobs, force_sync) {
	sh """
		mkdir -p aosp

		pushd aosp

		if [ "${force_sync}" == "true" ]; then
			rm -f .${branch}
		fi

		if [ ! -e .${branch} ]; then

			repo init -u https://android.googlesource.com/platform/manifest -b ${branch}
			repo sync -cd -j ${num_parallel_jobs}
			touch .${branch}

		fi

		popd
	"""
}
