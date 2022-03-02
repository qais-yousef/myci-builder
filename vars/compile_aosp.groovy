def call(target, num_parallel_jobs, uibench=false, jankbench=false) {
	sh """
		pushd aosp

		source build/envsetup.sh
		lunch ${target}
		m -j ${num_parallel_jobs}

		if [ "${uibench}" == "true" ]; then
			pushd frameworks/base/tests/UiBench
			mm -j ${num_parallel_jobs}
			popd
		fi

		if [ "${jankbench}" == "true" ]; then
			pushd frameworks/base/tests/JankBench
			mm -j ${num_parallel_jobs}
			popd
		fi

		popd
	"""
}
