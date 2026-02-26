class Solution(object):

    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l,r=0,len(height)-1
        lmax,rmax=0,0
        ans=0
        while l<r:
            lmax=max(lmax,height[l])
            rmax=max(rmax,height[r])
            if (lmax<rmax):
                ans+=(lmax-height[l])
                l+=1
            else:
                ans+= (rmax-height[r])
                r-=1
        return ans