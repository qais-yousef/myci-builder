def call(repo_dir, branch) {
	sh """
		pushd ${repo_dir}

		repo forall -c "git format-patch --suffix=\\"--myci.patch\\" ${branch}..HEAD" || true
		repo forall -c "git format-patch --suffix=\\"--myci.patch\\" m/${branch}..HEAD" || true

		popd
	"""
}
