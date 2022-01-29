def call(branch) {
	sh """
		pushd aosp

		repo forall -c "git format-patch --suffix=\\"--myci--\\\$(echo \\\$REPO_PROJECT | sed 's#/#_#g').patch\\" ${branch}..HEAD" || true

		popd
	"""
}
